import json

def isChinese(word):
    for ch in word:
        if '\u4e00' <= ch <= '\u9fff':
            return True
    return False

def do():
    with open('originData.json', 'r', encoding='utf-8') as f:
        json_data = json.load(f)
        tcms = json_data['data']
        for tcm in tcms:
            try:
                if len(tcm['拼音'])==0:
                    tcm['拼音']=input(tcm['中药名']+':')
                if ' ' in tcm['拼音']:
                    tcm['拼音'] = input(tcm['中药名'] + ':')
                if not tcm['拼音'].isalpha():
                    tcm['拼音'] = input(tcm['中药名'] + ':')
                if isChinese(tcm['拼音']):
                    tcm['拼音'] = input(tcm['中药名'] + ':')
                if '归经' not in tcm:
                    inductive = {"归经": ""}
                    tcm.update(inductive)
            except TypeError as e:
                continue

        json_data['data']=tcms
        with open('data/tcmData.json', 'a', encoding="utf-8") as f:
            f.write(json.dumps(json_data, ensure_ascii=False))

if __name__ == "__main__":
    do()