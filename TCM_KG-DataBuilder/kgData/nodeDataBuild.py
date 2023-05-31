import json

def isChinese(word):
    for ch in word:
        if '\u4e00' <= ch <= '\u9fff':
            return True
    return False


maps = ['北京', '天津', '上海', '重庆', '河北', '山西',
        '辽宁', '吉林', '黑龙江', '江苏', '浙江', '安徽',
        '福建', '江西', '山东', '河南', '湖北', '湖南',
        '广东', '海南', '四川', '贵州', '云南', '陕西',
        '甘肃', '青海', '台湾', '内蒙古', '广西', '西藏',
        '宁夏', '新疆', '香港', '澳门']
seasons = ['春', '夏', '秋', '冬']
properties=['寒', '凉', '温', '热']
tastes=['辛', '甘', '酸', '苦', '咸']
inductives=['胃', '脾', '大肠', '肾', '肺', '心', '肝', '膀胱', '胆', '三焦', '小肠', '心包']

def do():
    with open('data/node.txt', 'a', encoding='utf-8') as f:
        f.write('中药材\t'+'中药材\n')
        for map in maps:
            f.write('分布\t'+map+'\n')
        for season in seasons:
            f.write('采收季节\t'+season+'\n')
        for property in properties:
            f.write('四性\t'+property+'\n')
        for taste in tastes:
            f.write('五味\t'+taste+'\n')
        for inductive in inductives:
            f.write('归经\t'+inductive+'经\n')
    f.close()

    with open('C:\\Users\\zei\\Desktop\\tcmDataBuilder\\originData\\data\\tcmData.json', 'r', encoding='utf-8') as f:
        json_data = json.load(f)
        tcms = json_data['data']
        for tcm in tcms:
            with open('data/node.txt', 'a', encoding='utf-8') as f:
                f.write('中药名\t'+tcm['中药名']+'\n')
            if isChinese(tcm['别名']):
                strs = []
                str = tcm['别名'].split('、')
                for st in str:
                    ss = st.split('，')
                    strs.extend(ss)
                with open('data/node.txt', 'a', encoding='utf-8') as f:
                    for s in strs:
                        f.write('别名\t' + s.replace('。', '') + '\n')
                    f.close()

    with open("data/functionRelation1.json", "r", encoding="utf-8") as f:
        json_data = json.load(f)
        functions = json_data['data']
        for function in functions:
            for key in function:
                with open('data/node.txt', 'a', encoding='utf-8') as f:
                    f.write('功能\t'+key+'\n')
                f.close()

if __name__ == "__main__":
    do()
