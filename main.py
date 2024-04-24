from tkinter import messagebox, Tk
import pygame
import sys

# Height and width of the game window, not cell 
window_height = 500
window_width = 500

# Grid columns and rows
columns=25
rows=25

# Cell dimensions
box_width = window_width//columns
box_height = window_height//rows

# grid will store all the individual boxes
grid=[]

class Box: 
    # i, j are the position along x and y axes of the grid
    def __init__(self, i, j):
        self.x = i
        self.y = j
        self.start = False # True if the box is starting box
        self.wall = False # True if the box is a wall
        self.target = False # True if the box is the target
    # The method draw will draw each box(cell)
    # win = grid where we are drawing 
    # color = color of cell
    def draw(self, win, color):
        pygame.draw.rect(win, color, (self.x * box_width, self.y * box_height, box_width - 2, box_height - 2))
        
for i in range(columns):
    arr = []
    for j in range(rows):
        arr.append(Box(i,j))
    grid.append(arr)
# Selecting start_box in the grid
start_box = grid[0][0]
start_box.start = True







window = pygame.display.set_mode((window_height, window_width))
columns= 
def main():
    begin_search = False
    target_box_false = False
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
        window.fill((0,0,0))
        pygame.display.flip()

main()
