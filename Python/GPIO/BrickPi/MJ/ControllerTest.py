'''
Created on Mar 10, 2015

@author: johnson_marcus
'''

import pygame

pygame.init()
j = pygame.joystick.Joystick(0)
j.init()
print 'Initilized Joystick : %s' % j.get_name()

def get():
    out = [0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    it = 0
    pygame.event.pump()
    
    for i in range(0, j.get_numaxes()):
        out[it] = j.get_axis(i)
        it+=1
        
    for i in range(0, j.get_numbuttons()):
        out[it] = j.get_button(i)
        it+=1
    return out;

while True:
    print get()