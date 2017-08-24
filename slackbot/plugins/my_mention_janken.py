# coding: utf-8
from slackbot.bot import respond_to
from slackbot.bot import listen_to
import random

@respond_to('グー')
def respond_jangu(message):
    x = random.randint(1,3)
    if x == 1:
        message.reply('グー')
        message.reply('あいこです')
    elif x == 2:
        message.reply('チョキ')
        message.reply('私の負けです')
    else:
        message.reply('パー')
        message.reply('私の勝ちです')

@respond_to('チョキ')
def respond_jancho(message):
    x = random.randint(1,3)
    if x == 1:
        message.reply('グー')
        message.reply('私の勝ちです')
    elif x == 2:
        message.reply('チョキ')
        message.reply('あいこです')
    else:
        message.reply('パー')
        message.reply('私の負けです')

@respond_to('パー')
def respond_janpa(message):
    x = random.randint(1,3)
    if x == 1:
        message.reply('グー')
        message.reply('私の負けです')
    elif x == 2:
        message.reply('チョキ')
        message.reply('私の勝ちです')
    else:
        message.reply('パー')
        message.reply('あいこです')
