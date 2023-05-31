import requests
from lxml import etree
from fake_useragent import UserAgent
import json

headers = {'User-Agent': str(UserAgent().random)}
articles=[]
def get_word(url):
    article={}
    response = requests.get(url, headers=headers)
    response.encoding = 'gbk'
    dom = etree.HTML(response.text)
    title = dom.xpath('//div[@class="content hk"]/h1/text()')[0]
    article.update({"title": title})
    print(title)
    article.update({'type': '药材行情'})
    str = dom.xpath('//div[@class="ct01"]/text()')[0]
    ss=str.split('\u3000')
    article.update({"time": ss[1]})
    article.update({"user": ss[2]})
    text = dom.xpath('//div[@class="ct02"]/font[@id="remark_view"]/div/div/text()')
    context=""
    for line in text:
        context+=line
    article.update({"text": context})
    articles.append(article)


def get_urls(url):
    response = requests.get(url, headers=headers)
    response.encoding = 'utf-8'
    html = etree.HTML(response.text)
    url_list = [x for x in html.xpath('//div[@class="structItemContainer-group"]/div[@class="structItem"]/li/p/a/@href')]
    return url_list

if __name__ == '__main__':
    url = 'https://www.hxzylt.com/forums/392/'
    url_list=get_urls(url)
    for url_ in url_list:
        get_word(url_)
    data = {"data": articles}

    with open('data/data3.json', 'w', encoding="utf-8") as f:
        f.write(json.dumps(data, ensure_ascii=False))