import pymysql

conn = pymysql.connect(
    host="localhost",
    user="root",
    password="rg0608",
    database="tcm_kg",
    port=3306
)

cur = conn.cursor()

sql = "INSERT INTO userss (user_id, user_name, user_password, user_sex, user_email, user_phone, user_status, register_time, user_birthday, user_img, user_fans, user_concern, user_like, user_view) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) "

for i in range(0,100):
    user_id=0

# value = (tcm_id, tcm_name_zh, tcm_name_en, tcm_pinyin,
#                  tcm_come, tcm_traits, tcm_plant, tcm_distribution,
#                  tcm_produce, tcm_inductive, tcm_taste, tcm_note,
#                  tcm_function, tcm_clinical, tcm_alias, tcm_pharmacological, tcm_chemical)
#         cur.execute(sql, value)
#         conn.commit()

cur.close()
conn.close()