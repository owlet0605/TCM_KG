import requests
from bs4 import BeautifulSoup
from originData import getEachPages
import json

headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.146 Safari/537.36'
}

tcms = []
for page in range (1, 46):

    page_url = 'http://www.zhongyoo.com/name/page_'+ str(page) + '.html'
    res = requests.get(page_url, headers=headers)
    res.encoding = 'GBK'
    soup = BeautifulSoup(res.text, 'lxml')

    try:
        medicines = soup.find('div', {'class': 'r2-con'}).find_all('div', {'class': 'sp'})

        for medicine in medicines:
            url = medicine.find('a').get('href')
            tcms.append(getEachPages.getByURL(url))

    except AttributeError as e:
        print('Error!', e)
        continue

for tcm in tcms:
    tcm['拼音'] = tcm['拼音'].replace(tcm['中药名'] + " ", '')
    if len(tcm['植物形态']) >= 250:
        tcm['植物形态'] = '$$' + tcm['植物形态']
    if len(tcm['药材性状']) >= 250:
        tcm['药材性状'] = '$$' + tcm['药材性状']
    if len(tcm['药理研究']) >= 250:
        tcm['药理研究'] = '$$' + tcm['药理研究']

    str = tcm['性味归经'].split('。')
    taste = {"性味": str[0]}
    tcm.update(taste)
    if len(str)>1:
        inductive = {"归经": str[1]}
        tcm.update(inductive)
    tcm.pop('性味归经')

    if '性味功能' in tcm:
        if '性味' in tcm and '归经' in tcm:
            tcm.pop('性味功能')
        else:
            str = tcm['性味功能'].split('。')
            taste = {"性味": str[0]}
            tcm.update(taste)
            if len(str) > 1:
                inductive = {"归经": str[1]}
                tcm.update(inductive)
            tcm.pop('性味功能')

    if '药方' in tcm:
        tcm.pop('药方')
    if '配伍药方' in tcm:
        tcm.pop('配伍药方')
    if '相关推荐文章' in tcm:
        tcm.pop('相关推荐文章')
    if '外语名' in tcm:
        tcm.pop('外语名')
    if '短葶山麦冬' in tcm:
        tcm.pop('短葶山麦冬')
    if '附1 满山红油' in tcm:
        tcm.pop('附1 满山红油')
    if '姜黄' in tcm:
        tcm.pop('姜黄')
    if '广西莪术' in tcm:
        tcm.pop('广西莪术')
    if '蓬莪术' in tcm:
        tcm.pop('蓬莪术')
    if '绿泥石化云母碳酸盐片岩' in tcm:
        tcm.pop('绿泥石化云母碳酸盐片岩')
    if '配合药方' in tcm:
        tcm.pop('配合药方')
    if '千金子霜' in tcm:
        tcm.pop('千金子霜')
    if '现代研究' in tcm:
        tcm.pop('现代研究')
    if '相关药方' in tcm:
        tcm.pop('相关药方')
    if '用法用量' in tcm:
        tcm.pop('用法用量')
    if '正名' in tcm:
        tcm.pop('正名')

data={"data": tcms}

with open('originData.json', 'w', encoding="utf-8") as f:
    f.write(json.dumps(data, ensure_ascii=False))


