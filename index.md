# ImageHoster

This is a image hosting project using java, maven, springboot and JPA

How to clone
```
$ git config --global user.name "Your name here"
$ git config --global user.email "your_email@example.com"

$ git clone https://github.com/imnoor/ImageHoster.git
$ git remote add origin https://github.com/imnoor/Test.git
$ git branch -M main

#make some edits and commit local
$ git commit -m "Some relevant comment"

#act global, i mean push
$ git push -u origin main
```

if local rep is screwed for some reason and would like to do a clean pull from remote
```
$ git clean -f
$ git fetch --all

```
#Known issues
The @ManyToMany mapping between images and tags seems to raise some error in startup log, however the program seeem to run well.
