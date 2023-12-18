# ASCII Art

[![pipeline status](https://gitlab.fit.cvut.cz/BI-OOP/B201/asciiart/badges/master/pipeline.svg)](https://gitlab.fit.cvut.cz/BI-OOP/B201/asciiart)

The idea of this project is to load images, translate them into ASCII ART images, optionally apply filters, and save them. (https://courses.fit.cvut.cz/BI-OOP/projects/ASCII-art.html)


## Arguments:
### Load an image:
One of the following is required:
*  --image-random
*  --image "path"
    * path must lead to an existing file and end int .jpg or .png

### Transformation table:
One of the following is required:
* --table paul-bourkes
* --table lame
* --custom-table "characters"
    * characters must be a string of length 1 to 256

### Image export:
One of the following is required:
* --output-console
* --output-file "path"

### Filters:
Any combination of the following is allowed:
* --invert
* --flip "axis"
    * axis must be either "x" or "y" for flip along x or y axis respectively
* --brightness amount
    * amount must be an integer

