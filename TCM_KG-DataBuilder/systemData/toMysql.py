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

userInsertSql = "insert into userss (user_id, user_name, user_password, user_sex, user_email, user_phone, " \
                "user_status, register_time, user_birthday, user_img, user_fans, user_concern, user_like, " \
                "user_view, user_security) values (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) "
typeInsertSql = "insert into article_type (article_type_id, article_type_tag, article_type_describe, article_type_num) " \
                "values (%s, %s, %s, %s) "
articleInsertSql = "insert into article (article_id, article_user_id, article_type_id, article_title, " \
                   "article_context, article_time, article_view, article_comment, article_like, article_collect, " \
                   "article_audit) values (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"
with open('data/data3.json', 'r', encoding='utf-8') as f:
    json_data = json.load(f)
    articles = json_data['data']
    num = 100000017
    for article in articles:
        sql1 = "select * from userss where user_name='" + article['user'] + "'"
        cur.execute(sql1)
        user = cur.fetchone()
        if user is None:
            user_id = 0
            user_name = article['user']
            user_password = "123456"
            user_sex = "女" if np.random.randint(2, size=1) == 0 else "男"
            user_email = str(num) + "@gmail.com"
            user_phone = "11" + str(num)
            user_status = 1
            register_time = "2022-03-01 01:00:00"
            user_birthday = "2000-06-01"
            user_img = "default.png"
            user_fans = 0
            user_concern = 0
            user_like = 0
            user_view = 0
            user_security = 0
            value = (user_id, user_name, user_password, user_sex, user_email, user_phone, user_status,
                     register_time, user_birthday, user_img, user_fans, user_concern, user_like, user_view, user_security)
            cur.execute(userInsertSql, value)
            conn.commit()
            num += 1

        sql2 = "select * from article_type where article_type_tag='" + article['type'] + "'"
        cur.execute(sql2)
        articleType = cur.fetchone()
        if articleType is None:
            article_type_id = 0
            article_type_tag = article['type']
            article_type_describe = article['type'] + "板块"
            article_type_num = 1
            value = (article_type_id, article_type_tag, article_type_describe, article_type_num)
            cur.execute(typeInsertSql, value)
            conn.commit()
        else:
            sql = "update article_type set article_type_num=%s where article_type_id='" + str(articleType[0]) + "'"
            update_data = [articleType[3] + 1]
            cur.execute(sql, update_data)
            conn.commit()

        article_id = 0
        cur.execute(sql1)
        article_user_id = cur.fetchone()[0]
        cur.execute(sql2)
        article_type_id = cur.fetchone()[0]
        article_title = article['title']
        article_context = article['text'].replace(' ', '\\n')
        article_time = article['time']
        article_view = 0
        article_comment = 0
        article_like = 0
        article_collect = 0
        article_audit = 1
        value = (article_id, article_user_id, article_type_id, article_title, article_context, article_time,
                 article_view, article_comment, article_like, article_collect, article_audit)
        cur.execute(articleInsertSql, value)
        conn.commit()

cur.close()
conn.close()
