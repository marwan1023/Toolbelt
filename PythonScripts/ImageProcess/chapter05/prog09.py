from PIL import Image, ImageTk, ImageFilter
import tkinter as tk


def show_value_1(window_size):
    print('Window Size: ', window_size)

    custom_filter = ImageFilter.ModeFilter(size=int(window_size))
    img = im1.filter(custom_filter)
    photo = ImageTk.PhotoImage(img)
    l['image'] = photo
    l.photo = photo

root = tk.Tk()
root.title('Mode Filter Demo')

im1 = Image.open("/home/pi/DIP/Dataset/4.1.04.tiff")

photo = ImageTk.PhotoImage(im1)

l = tk.Label(root, image=photo)
l.pack()
l.photo = photo

w1 = (tk.Scale(root, label="Window Size", from_=1, to=19,
      resolution=1, command=show_value_1, orient=tk.HORIZONTAL))
w1.pack()

root.mainloop()
