import json


def isChinese(word):
    for ch in word:
        if '\u4e00' <= ch <= '\u9fff':
            return True
    return False


maps = ['北京', '天津', '上海', '重庆', '河北', '山西',
        '辽宁', '吉林', '黑龙江', '江苏', '浙江', '安徽',
        '福建', '江西', '山东', '河南', '湖北', '湖南',
        '广东', '海南', '四川', '贵州', '云南', '陕西',
        '甘肃', '青海', '台湾', '内蒙古', '广西', '西藏',
        '宁夏', '新疆', '香港', '澳门']
seasons = ['春', '夏', '秋', '冬']
properties = ['寒', '凉', '温', '热']
tastes = ['辛', '甘', '酸', '苦', '咸']
inductives = ['胃', '脾', '大肠', '肾', '肺', '心', '肝', '膀胱', '胆', '三焦', '小肠', '心包']


def do():
    relations = []

    functions = []
    with open("data/function2.txt", "r", encoding="utf-8") as fr_n:
        for line in fr_n.readlines():
            line = line.strip()
            li = line.split(' ')
            functions.append(li)

    with open('C:\\Users\\zei\\Desktop\\tcmDataBuilder\\originData\\data\\tcmData.json', 'r', encoding='utf-8') as f:
        json_data = json.load(f)
        tcms = json_data['data']
        for tcm in tcms:
            relation = {'node_1': '中药材\t中药材', 'relation': 'include', 'node_2': '中药名\t' + tcm['中药名']}
            relations.append(relation)
            if isChinese(tcm['别名']):
                strs = []
                str = tcm['别名'].split('、')
                for st in str:
                    ss = st.split('，')
                    strs.extend(ss)
                for s in strs:
                    relation = {'node_1': '中药名\t' + tcm['中药名'], 'relation': 'alias',
                                'node_2': '别名\t' + s.replace('。', '')}
                    relations.append(relation)
            for map in maps:
                if map in tcm['产地分布']:
                    relation = {'node_1': '中药名\t' + tcm['中药名'], 'relation': 'distribution', 'node_2': '分布\t' + map}
                    relations.append(relation)
            for season in seasons:
                if season in tcm['采收加工']:
                    relation = {'node_1': '中药名\t' + tcm['中药名'], 'relation': 'season', 'node_2': '采收季节\t' + season}
                    relations.append(relation)
            for property in properties:
                if property in tcm['性味']:
                    relation = {'node_1': '中药名\t' + tcm['中药名'], 'relation': 'property', 'node_2': '四性\t' + property}
                    relations.append(relation)
            for taste in tastes:
                if taste in tcm['性味']:
                    relation = {'node_1': '中药名\t' + tcm['中药名'], 'relation': 'taste', 'node_2': '五味\t' + taste}
                    relations.append(relation)
            for inductive in inductives:
                if inductive in tcm['归经']:
                    relation = {'node_1': '中药名\t' + tcm['中药名'], 'relation': 'inductive',
                                'node_2': '归经\t' + inductive + '经'}
                    relations.append(relation)
            with open('data/functionRelation.json', 'r',
                      encoding='utf-8') as ff:
                json_data = json.load(ff)
                functions = json_data['data']
                for function in functions:
                    for key in function:
                        if key==tcm['中药名']:
                            relation = {'node_1': '中药名\t' + tcm['中药名'], 'relation': 'function',
                                        'node_2': '功能\t' + function[key]}
                            relations.append(relation)
            # if len(tcm['功效作用']) > 0:
            #     func = []
            #     str = tcm['功效作用'].split('。')
            #     st = str[0].split('，')
            #     for ss in st:
            #         s = ss.split('、')
            #         for c in s:
            #             for function in functions:
            #                 if c in function:
            #                     func.append(function[0])
            #                     break
            #     func = list(set(func))
            #     for fun in func:
            #         relation = {'node_1': '中药名\t' + tcm['中药名'], 'relation': 'function',
            #                     'node_2': '功能\t' + fun}
            #         relations.append(relation)

    with open('data/relation.json', 'w', encoding="utf-8") as f:
        f.write(json.dumps(relations, ensure_ascii=False))

if __name__ == "__main__":
    do()
