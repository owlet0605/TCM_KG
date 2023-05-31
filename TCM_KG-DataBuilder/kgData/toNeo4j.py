import json
from py2neo import Graph, Node, Relationship


def generateGraphNode(graph, label, name):

    node = Node(label, name=name)
    graph.create(node)

    return node


def generateGraphRelation(graph, node_1, relation, node_2):

    r = Relationship(node_1, relation, node_2)
    graph.create(r)


def createGraphTcm():

    connect_graph = Graph("http://localhost:7474", user="neo4j", password="200106050519r..", name="neo4j")

    dict_nodes = {}
    with open("data/node.txt", "r", encoding="utf-8") as fr_n:
        for line in fr_n.readlines():
            line = line.strip()
            lable, name = line.split("\t")

            node = generateGraphNode(connect_graph, lable, name)
            dict_nodes[line] = node

    with open("data/relation.json", "r", encoding="utf-8") as fr_r:
        for ele in json.load(fr_r):
            node_1 = ele["node_1"].strip()
            relation = ele["relation"]
            node_2 = ele["node_2"].strip()
            node_1_g = dict_nodes[node_1]
            node_2_g = dict_nodes[node_2]

            generateGraphRelation(connect_graph, node_1_g, relation, node_2_g)


if __name__ == '__main__':
    createGraphTcm()
    pass