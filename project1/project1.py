#yanxx630
#Project01

class Random:
    def __init__(self,seed):
        self.__seed = seed

    def next(self):
        nextseed = (16807 * self.__seed) % (2147483648-1)
        self.__seed = nextseed
        return nextseed

    def choose(self,objects):
        a = self.next() % len(objects)
        return objects[a]

class Grammar:
    def __init__(self,seed):
        self.r = Random(seed)
        self.dic = {}

    def rule(self,left,right):
        if left in self.dic:
            self.dic[left].append(right)
            #self.dic[left] += [right]
        else:
            self.dic[left] = [right]

    def generate(self):
        if 'Start' in self.dic:
            string1 = self.generating(('Start',))
            return string1
        else:
            raise Expception('can’t generate strings without a rule for "Start".')


    def generating(self,strings):
        local = ''
        for i in strings:
            if i not in self.dic:
                local += i + ' '
            else:
                vtuple = self.r.choose(self.dic[i])
                vstring = self.generating(vtuple)
                local += vstring
        return local


#Test1 Class Random
r = Random(101)
print(r.next())
print(r.next())
print(r.next())
print(r.next())
print(r.next())
print(r.next())
print(r.next())
print(r.next())


#Test2 Class Grammar
G = Grammar(101)  
G.rule('Noun',   ('cat',))                                #  01  
G.rule('Noun',   ('boy',))                                #  02  
G.rule('Noun',   ('dog',))                                #  03  
G.rule('Noun',   ('girl',))                               #  04  
G.rule('Verb',   ('bit',))                                #  05  
G.rule('Verb',   ('chased',))                             #  06  
G.rule('Verb',   ('kissed',))                             #  07  
G.rule('Phrase', ('the', 'Noun', 'Verb', 'the', 'Noun'))  #  08  
G.rule('Story',  ('Phrase',))                             #  09  
G.rule('Story',  ('Phrase', 'and', 'Story'))              #  10  
G.rule('Start',  ('Story', '.'))                          #  11

print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
