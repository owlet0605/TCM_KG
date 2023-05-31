import pymysql
import json

conn = pymysql.connect(
    host="localhost",
    user="root",
    password="rg0608",
    database="tcm_kg",
    port=3306
)

cur = conn.cursor()

sql = "INSERT INTO tcm (tcm_id, tcm_name_zh, tcm_name_en, tcm_pinyin, tcm_come, tcm_traits, tcm_plant, " \
      "tcm_distribution, tcm_produce, tcm_inductive, tcm_taste, tcm_note, tcm_function, tcm_clinical, tcm_alias, " \
      "tcm_pharmacological, tcm_chemical) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) "

with open('data/tcmData.json', 'r', encoding='utf-8') as f:
    json_data = json.load(f)
    tcms = json_data['data']
    print(len(tcms))
    for tcm in tcms:
        tcm_id=0
        tcm_name_zh=tcm['中药名']
        tcm_name_en=tcm['英文名']
        tcm_pinyin=tcm['拼音']
        tcm_come=tcm['来源']
        if tcm['药材性状'].startswith('$$'):
            tcm_traits=tcm['药材性状'].replace('$$','')
        else:
            tcm_traits=tcm['药材性状']
        if tcm['植物形态'].startswith('$$'):
            tcm_plant=tcm['植物形态'].replace('$$','')
        else:
            tcm_plant=tcm['植物形态']
        tcm_distribution=tcm['产地分布']
        tcm_produce=tcm['采收加工']
        tcm_inductive=tcm['归经']
        tcm_taste=tcm['性味']
        tcm_note=tcm['使用禁忌']
        tcm_function=tcm['功效作用']
        tcm_clinical=tcm['临床应用']
        tcm_alias=tcm['别名']
        if tcm['药理研究'].startswith('$$'):
            tcm_pharmacological=tcm['药理研究'].replace('$$','')
        else:
            tcm_pharmacological=tcm['药理研究']
        tcm_chemical=tcm['主要成分']

        value = (tcm_id, tcm_name_zh, tcm_name_en, tcm_pinyin,
                 tcm_come, tcm_traits, tcm_plant, tcm_distribution,
                 tcm_produce, tcm_inductive, tcm_taste, tcm_note,
                 tcm_function, tcm_clinical, tcm_alias, tcm_pharmacological, tcm_chemical)
        cur.execute(sql, value)
        conn.commit()

cur.close()
conn.close()
