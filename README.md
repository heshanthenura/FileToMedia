# <h1 align="center">File to Video or Image Converter <code>BETA</code> </h1>

#### You can convert file into a video or an image and upload it to YouTube or somewhere else to get unlimited storage.

* I converted this [text file](https://github.com/heshanthenura/FileToVideo/blob/main/text.txt) into the image below:

<img src="https://user-images.githubusercontent.com/75155192/221347829-6fe3229d-8f56-4234-ac26-0beb0bcd8353.png">

### 1. First I read the file and converted into bits.
> I converted the file into bits because, if we converted the file into bytes we have to use rgb color for pixels. If any kind of compression is done by uploaded platform the upload file will change.Because of that I used bits

### 2. Then I assigned the pixel color according to the bit value.

> * If the bit value is ```1``` I assigned the white color.
> * If the bit value is ```0``` I assigned the black color.

> ###  Here im using image resolution as ```600x400``` so total amount of pixels are ```240000``` but the total number of bits that [text file](https://github.com/heshanthenura/FileToVideo/blob/main/text.txt) contains is less than ```240000``` so for remaining pixels I assigned the red color.


### <h1 align="center">**_`I'm Implementing this with more features Soon`_**</h1>