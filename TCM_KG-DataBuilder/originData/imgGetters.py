import requests
from bs4 import BeautifulSoup
import os

headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.146 Safari/537.36'
}


def getByURL(url):
    url = url
    headers = {
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.146 Safari/537.36'
    }
    res = requests.get(url, headers=headers)
    res.encoding = 'GBK'
    soup = BeautifulSoup(res.text, 'lxml')

    src = soup.find('img').get('src')
    print("获取到图片地址：" + src)
    return src

if __name__ == "__main__":
    srcs = []
    for page in range(1, 46):

        page_url = 'http://www.zhongyoo.com/name/page_' + str(page) + '.html'
        res = requests.get(page_url, headers=headers)
        res.encoding = 'GBK'
        soup = BeautifulSoup(res.text, 'lxml')

        try:
            medicines = soup.find('div', {'class': 'r2-con'}).find_all('div', {'class': 'sp'})

            for medicine in medicines:
                url = medicine.find('a').get('href')
                srcs.append(getByURL(url))

        except AttributeError as e:
            print('Error!', e)
            continue

    n = 100000000
    root = "C://Users//zei//Desktop//TCM_KGSystem//src//main//resources//static//tcm//"
    for url in srcs:
        picName = str(n)
        n=n+1
        path = root + picName + ".jpg"
        try:
            if not os.path.exists(root):
                os.mkdir(root)
            if not os.path.exists(path):
                r = requests.get('http://www.zhongyoo.com'+url)
                with open(path, "wb") as f:
                    f.write(r.content)
                    f.close()
                    print(picName + "已经保存成功！")
            else:
                print(picName + "已存在！")
        except:
            print("爬取失败！")



