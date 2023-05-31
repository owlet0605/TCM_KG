import requests
from bs4 import BeautifulSoup
import json

headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.146 Safari/537.36'
}

functions = []
functions1 = []

def getByURL(url):
    url = url
    function_info = {}
    res = requests.get(url, headers=headers)
    res.encoding = 'GBK'
    soup = BeautifulSoup(res.text, 'lxml')

    function = soup.find('dt', {'class': 'letIn'}).find('a').get_text().strip().replace('药', '')
    lists = soup.find('dl', {'class': 'letList letList60'}).find_all('li')
    tcms=[]
    for list in lists:
        try:
            tcm = list.find('a').get_text().strip()
            print(function, tcm)
            tcms.append(tcm)
            function_info.update({tcm:function})
        except AttributeError as e:
            continue
    functions1.append({function : tcms})
    functions.append(function_info)




page_url = 'http://www.zhongyoo.com/gx/'
res = requests.get(page_url, headers=headers)
res.encoding = 'GBK'
soup = BeautifulSoup(res.text, 'lxml')

try:
    medicines = soup.find('div', {'class': 'listT1Con'}).find_all('ul', {'class': 'ksList'})
    for medicine in medicines:
        subs = medicine.find_all('li')
        for sub in subs:
            url = sub.find('a').get('href')
            getByURL(url)

except AttributeError as e:
    print('Error!', e)

data={"data": functions}
data1={"data": functions1}

with open('data/functionRelation.json', 'w', encoding="utf-8") as f:
    f.write(json.dumps(data, ensure_ascii=False))
with open('data/functionRelation1.json', 'w', encoding="utf-8") as f:
    f.write(json.dumps(data1, ensure_ascii=False))