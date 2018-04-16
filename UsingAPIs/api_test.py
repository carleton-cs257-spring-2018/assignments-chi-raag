#!/usr/bin/env python2
'''
    api_test.py
    Chiraag Gohel and Sharan Ganjam Sehachallam, 15 April 2018

    CS 257 Software Design - Assignment 2 - Using APIs
    Using the Intellexer API to summarize an article, or present a list of named
    entities that occur in the text.
    Modeled after Jeff Ondich's sample.
'''

import requests
import json
import argparse

def get_summary(url):
    '''
    Prints a line-by-line summary of the text. The length of the summary has been
    arbitrarily decided to be 10% of the original.
    '''
    
    first_api = "http://api.intellexer.com/summarize?apikey=d91243f9-1436-4842-8edd-6d460773fb55&url="
    url_api = url
    last_api = "&summaryRestriction=10&returnedTopicsCount=2&loadConceptsTree=true&loadNamedEntityTree=true&usePercentRestriction=true&conceptsRestriction=7&structure=general&fullTextTrees=true&textStreamLength=1000&useCache=false&wrapConcepts=true"
    
    main_api = first_api + url_api + last_api
    json_data = requests.get(main_api).json()

    for item in json_data['items']:
        print
        print(item['text'])

    print

def get_characters(url):
    '''
    Searches for named entites and prints them.
    '''
    
    first_api = "http://api.intellexer.com/recognizeNe?apikey=d91243f9-1436-4842-8edd-6d460773fb55&url="
    url_api = url
    last_api = "&loadNamedEntities=true&loadRelationsTree=true&loadSentences=true"

    main_api = first_api + url_api + last_api
    json_data = requests.get(main_api).json()

    for item in json_data['entities']:
        if(item['type'] ==1):
            print
            print(item['text'])
def main(args):
    if args.action == 'summary':
        get_summary(args.text)
    elif args.action == 'names':       
        get_characters(args.text)

if __name__ == '__main__':
    
    parser = argparse.ArgumentParser(description='Get information about your article from the Intellexer API!')

    parser.add_argument('action',
                        metavar='action',
                        help='information you want about the article "summary" or "names")',
                        choices=['summary', 'names'])

    parser.add_argument('text', help='the text you want information about')

    args = parser.parse_args()
main(args)
