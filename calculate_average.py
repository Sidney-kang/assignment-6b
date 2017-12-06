# Created by : Sidney Kang
# Created on : 29 Nov. 2017
# Created for : ICS3UR
# Weekly Assignment - Assignment #7
# This program calculates average of given levels continuously

import ui

marks_collection = []
marks = []

percentage_4_plus = 98
percentage_4 = 92
percentage_4_minus = 85
percentage_3_plus = 78
percentage_3 = 75
percentage_3_minus = 71
percentage_2_plus = 68
percentage_2 = 65
percentage_2_minus = 61
percentage_1_plus = 58
percentage_1 = 55
percentage_1_minus = 51
percentage_R = 30
percentage_NE = 0


def enter_mark_touch_up_inside(sender):
    
    user_input = str(view['enter_mark_textbox'].text)   
    user_input = user_input.upper()
    percentage_average(user_input)
    mark_entered = percentage_average(user_input)
    mark_entered = float(mark_entered)
       
    if mark_entered == -1:
       view['error_label'].text = "Please enter any level between ne - 4+ (eg. 1-)."
       view['enter_mark_textbox'].text = ""
    else:
       view['enter_mark_textbox'].text = ""
       marks.append(mark_entered)
       marks_collection.append(mark_entered)
    # This adds levels as percentages in the textview
    for mark in marks_collection:
        view['marks_textview'].replace_range((0,0), str(mark) + " ")
        del marks_collection[0]
        
def percentage_average(user_input):
    # This converts levels into percentages
    if user_input == "NE":
       percentage = percentage_NE
       return percentage
    elif user_input == "R":
       percentage = percentage_R
       return percentage
    elif user_input == "1+":
       percentage = percentage_1_plus
       return percentage
    elif user_input == "1":
       percentage = percentage_1
       return percentage
    elif user_input == "1-":
       percentage = percentage_1_minus
       return percentage
    elif user_input == "2":
       percentage = percentage_2 
       return percentage
    elif user_input == "2+": 
       percentage = percentage_2_plus
       return percentage
    elif user_input == "2-": 
       percentage = percentage_2_minus
       return percentage    	
    elif user_input == "3":
       percentage = percentage_3 
       return percentage
    elif user_input == "3+":
       percentage = percentage_3_plus
       return percentage
    elif user_input == "3-":
       percentage = percentage_3_minus
       return percentage
    elif user_input == "4":
       percentage = percentage_4
       return percentage
    elif user_input == "4+":
       percentage = percentage_4_plus 
       return percentage
    elif user_input == "4-":
       percentage = percentage_4_minus
       return percentage
    else:
       percentage = -1
       return percentage
        
def calculate_average(marks):
    # This calculates the average
    average = int((sum(marks)/len(marks))+0.5)
    
    return average
		
def show_average_touch_up_inside(sender):
    view['enter_mark_button'].enabled = True
    calculate_average(marks)
    show_average = calculate_average(marks)
    # This shows the average in percentage
    view['average_label'].text = "The average in percentage is: " + str(show_average) + "%"  

view = ui.load_view()
view.present('sheet')
