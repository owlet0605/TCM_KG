import numpy as np
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

sql1 = "select * from article"
cur.execute(sql1)
result = cur.fetchall()

for article in result:
    print(article[0])
    print(article[4])
    # content = article[4].replace('\\n', '\r\n')
    # print(content)
    # sql2 ="update article set article_context='"+content+"' where article_id='"+str(article[0])+"'"
    # cur.execute(sql2)
    # conn.commit()

cur.close()
conn.close()
