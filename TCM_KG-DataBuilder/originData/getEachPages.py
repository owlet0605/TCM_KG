import requests
from bs4 import BeautifulSoup


def getByURL(url):
    url = url
    medicine_info = {'中药名': '', '拼音': '', '别名': '', '英文名': '',
                     '来源': '', '植物形态': '', '产地分布': '', '采收加工': '',
                     '药材性状': '', '性味归经': '', '功效作用': '', '临床应用': '',
                     '主要成分': '', '药理研究': '', '使用禁忌': ''}
    headers = {
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.146 Safari/537.36'
    }
    res = requests.get(url, headers=headers)
    res.encoding = 'GBK'
    soup = BeautifulSoup(res.text, 'lxml')

    name = soup.find('div', {'class': 'title'}).find('h1').get_text().strip()
    medicine_info.update({'中药名': name})

    info_list = soup.find('div', {'class': 'gaishu'}).find('div', {'class': 'text'})
    descriptions = info_list.find_all('p')

    for description in descriptions:
        try:
            title = description.find('strong').get_text().strip()
            del_str = '【' + title + '】'
            text = description.get_text().strip().replace(del_str, '')
            print(title, text)
        except AttributeError as e:
            #print('Error!', e)
            continue

        if '药名' in title:
            title = '拼音'
        elif '别名' in title:
            title = '别名'
        elif '英文' in title:
            title = '英文名'
        elif '部位' in title:
            title = '来源'
        elif '来源' in title:
            title = '来源'
        elif '用法' in title:
            title = '用法用量'
        elif '形态' in title:
            title = '植物形态'
        elif '分布' in title:
            title = '产地分布'
        elif '产地' in title:
            title = '产地分布'
        elif '加工' in title:
            title = '采收加工'
        elif '性状' in title:
            title = '药材性状'
        elif '归经' in title:
            title = '性味归经'
        elif '功效' in title:
            title = '功效作用'
        elif '应用' in title:
            title = '临床应用'
        elif '成分' in title:
            title = '主要成分'
        elif '禁忌' in title:
            title = '使用禁忌'
        elif '药理' in title:
            title = '药理研究'

        medicine_info.update({title: text})

    return medicine_info
