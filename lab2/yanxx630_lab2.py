#CSCI1913
#LAB2
#yanxx630
class Zillion:
    def __init__(self,digits):
        self.__alist = []

        test1 = False
        test2 = True
        for i in digits:
            if i in "0987654321":
                test1 = True
            else:
                if i != "," and i != " ":
                    test2 = False

        if test1 and test2:
            for j in range(0,len(digits)): #remember the syntax for the range
                if digits[j] != "," and digits[j] != " ":
                    self.__alist.append(int(digits[j]))
        else:
            raise RuntimeError
        #print(self.__alist)
        self.__l = len(self.__alist) #this is comfusing sometime

    def toString(self):
        string1 = ""
        for i in range(len(self.__alist)):
            string1 = string1 + str(self.__alist[i])
        return string1

    def isZero(self):
        j = 0
        for i in range(len(self.__alist)):
            if self.__alist[i] != 0:
                return False
        return True

    def increment(self):

        if self.__alist [len(self.__alist)-1] != 9:
             self.__alist[len(self.__alist)-1] += 1

        else:
            count = len(self.__alist)-1

            while count >= 0 and self.__alist[count] == 9:
                self.__alist[count] = 0
                count -= 1

            if count == -1:
                self.__alist = [1] + self.__alist
                #print(self.__alist)
            else:
                self.__alist[count] += 1  #conclude the circumstances correctly
            
        


#
#  TESTS. Test the class Zillion for CSci 1913 Lab 2.
#
#    James Moen
#    18 Sep 17
#
#  Every test is followed by a comment which shows what must be printed if your
#  code works correctly. It also shows how many points the test is worth.
#

try:
  z = Zillion('')
except RuntimeError:
  print('Empty string')

# It must print 'Empty string' without apostrophes. 2 points.

try:
  z = Zillion(' , ')
except RuntimeError:
  print('No digits in the string')

# It must print 'No digits in the string' without apostrophes. 2 points.

try:
  z = Zillion('1+0')
except RuntimeError:
  print('Non-digit in the string')

# It must print 'Non-digit in the string' without apostrophes. 2 points.

try:
  z = Zillion('0')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000000000')
  #print("test2")
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000 000 000')
  #print("test3")
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('997')
  #print("test4")
except RuntimeError:
  print('This must not be printed')

#  It must print nothing.  2 points.

print(z.isZero())    #  It must print False. 2 points.

print(z.toString())  #  It must print 997. 2 points.

z.increment()

print(z.toString())  #  It must print 998. 2 points.

z.increment()

print(z.toString())  #  It must print 999. 2 points.

z.increment()

print(z.toString())  #  It must print 1000. 2 points.

try:
  z = Zillion('0 9,9 9')
except:
  print('This must not be printed')

#  It must print nothing.  3 points.

z.increment()
print(z.toString())  #  It must print 1000. 2 points.



#Results:

##============= RESTART: /home/yanxx630/1913/lab2/yanxx630_lab2.py =============
##Empty string
##No digits in the string
##Non-digit in the string
##True
##True
##True
##False
##997
##998
##999
##1000
##1000
##>>> 
