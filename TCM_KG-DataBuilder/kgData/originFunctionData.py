import json

with open('C:\\Users\\zei\\Desktop\\tcmDataBuilder\\originData\\data\\tcmData.json', 'r', encoding='utf-8') as f:
    json_data = json.load(f)
    tcms = json_data['data']
    functions = []
    for tcm in tcms:
        if len(tcm['功效作用']) > 0:
            str = tcm['功效作用'].split('。')
            st = str[0].split('，')
            for s in st:
                function = s.split('、')
                functions.extend(function)
    functions = list(set(functions))
    with open('data/function1.txt', 'a', encoding='utf-8') as f:
        for function in functions:
            f.write(function + '\n')
        f.close()