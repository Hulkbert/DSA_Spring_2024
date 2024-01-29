"""
Functions to print the first numbers of the look-and-say sequence.
"""


def next_number(look_and_say_num):
    """
    Replace this line with your docstring.
    """
    heck=str(look_and_say_num)+ " "
    counter=1
    i=0
    new_string=""
    if heck == 1:
        new_string=counter+heck
    else:
        while i<len(heck)-1:
            if heck[i]==heck[i+1]:
                counter+=1
                i += 1
            else:
                new_string=new_string+str(counter)+heck[i]
                counter=1
                i += 1
    return new_string
        


def look_and_say(length):
    """
    Replace this line with your docstring.
    """
    num_current=1
    for i in range(length):
        print(num_current)
        num_current=next_number(num_current)
    pass
