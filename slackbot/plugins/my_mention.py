# coding: utf-8
from slackbot.bot import respond_to
from slackbot.bot import listen_to
import random

@respond_to('こんにちは') #bot宛てのみ反応
def respond_func(message):
    message.reply('こんにちは')

@listen_to('課題') #参加しているチャンネルで反応
def listen_func(message):
    message.reply('頑張って!')
