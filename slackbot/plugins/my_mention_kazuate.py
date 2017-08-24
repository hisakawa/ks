# coding: utf-8
from slackbot.bot import respond_to
from slackbot.bot import listen_to
import random
kazuate_x = '10'    #当てる数
kazuate_count = 1   #数の挑戦回数のカウント

@respond_to('数当てゲーム')
def respond_kazu(message):
    global kazuate_x
    x = random.randint(0,9)
    kazuate_x = str(x)
    message.reply('数を決めました')
    message.reply('0から9までの範囲です')
    #message.reply(x)


@respond_to('^[0123456789]$')
def respond_suji(message):
    global kazuate_x
    global kazuate_count
    #message.reply('数字です')
    text = message.body['text']
    message.reply(text)
    #message.reply(x)
    if int(kazuate_x) == 10:
        message.reply('数当てゲームと言うと数をセットします')
    elif int(kazuate_x) < int(text):
        message.reply('その数より低いです')
        kazuate_count += 1
    elif int(kazuate_x) > int(text):
        message.reply('その数より高いです')
        kazuate_count += 1
    else:
        message.reply('正解です')
        message.react('+1')
        message.reply(str(kazuate_count) + '回挑戦しました')
        kazuate_x = '10'
        kazuate_count = 1
