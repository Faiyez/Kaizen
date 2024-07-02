from tkinter import messagebox, Tk
import pygame
import sys

# Height and width of the game window, not cell 
window_height = 500
window_width = 500
window = pygame.display.set_mode((window_width, window_height))
# Grid columns and rows
columns=50
rows=50

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

def main():
    print(len(grid))
    begin_search = False
    target_box_set = False

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
                # Condition for mouse motion
            elif event.type == pygame.MOUSEMOTION:
                x = pygame.mouse.get_pos()[0]
                y = pygame.mouse.get_pos()[1]
                # Left mouse button pressed and wall will be created
                if event.buttons[0]:
                    i = x
                    j = y
                    print(i,j)
                    grid[i][j].wall = True
                    # Setting Target
                if event.buttons[2] and not target_box_set:
                    i = x
                    j = y
                    target_box = grid[i][j]
                    target_box.target = True
                    target_box_set = True
            if event.type == pygame.KEYDOWN and target_box_set:
                begin_search = True

        window.fill((10,30,30))

        for i in range(columns):
            for j in range(rows):
                box = grid[i][j]
                box.draw(window, (0,0,0))
                if box.start:
                    box.draw(window,(0,200,200))
                if box.wall:
                    box.draw(window,(90,90,90))
                if box.target:
                    box.draw(window,(200,200,0))
        test_box=grid[49][49]
        test_box.draw(window,(0,200,200))
        pygame.display.flip()

main()
