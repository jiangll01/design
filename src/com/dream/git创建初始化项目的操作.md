**github账号：jiangll521   密码： 5282753li   邮箱：18801301902@163.com**

**github账号：jiangxingli   密码： 5282753li   邮箱：1031368832@qq.com**

**github账号：jiangll01   密码： 5282753li   邮箱：jiangll01@inspur.com(主要账号)**



####  git创建初始化项目的操作()

**命令行操作**

1、先在远端创建一个项目，如果项目添加了md文件，需要先git pull 拉去代码

2、本地代码进行git初始化

3、git remote add origin + 远端地址

4、git pull origin master --allow-unrelated-histories //把远程仓库和本地同步，消除差异，主要是创建的时候创建了read.md文件，所以去差异化。

5、将本地代码提交到远端命令： git push -u origin master （第一次提交的时候，必须加-u,往后就可以不用添加了）

#####  idea把项目添加到github上

- 1、第一步：本地代码进行版本控制，即创建本地git仓库，将我们的代码全部commit到本地仓库

![我是](https://img-blog.csdnimg.cn/20200804161618550.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTczMTk5,size_16,color_FFFFFF,t_70)
- 2、首先注册github用户，注册完成后，首先我们需要将本地git的公钥添加到github上，这样我们以后访问就不需要输入用户名和密码了。点击**setting**

<img src="C:\Users\jiangll01\AppData\Roaming\Typora\typora-user-images\image-20200804153231173.png" alt="image-20200804153231173" style="zoom: 33%;" />

选择**ssh and GPG keys**

<img src="C:\Users\jiangll01\AppData\Roaming\Typora\typora-user-images\image-20200804153342774.png" alt="image-20200804153342774" style="zoom: 33%;" />

git生成的公钥私钥位置一般应该时跟我一样（git的公钥私钥生成请看相关知识）

<img src="C:\Users\jiangll01\AppData\Roaming\Typora\typora-user-images\image-20200804153436199.png" alt="image-20200804153436199" style="zoom: 50%;" />

- 3、github创建仓库时注意，如果我们已经本地进行了仓库管理，就不要添加这个。

<img src="C:\Users\jiangll01\AppData\Roaming\Typora\typora-user-images\image-20200804153742818.png" alt="image-20200804153742818" style="zoom: 33%;" />

- 4、将我们的远程仓库地址 ssh 地址添加到本地中

<img src="C:\Users\jiangll01\AppData\Roaming\Typora\typora-user-images\image-20200804153954880.png" alt="image-20200804153954880" style="zoom:33%;" />



- 5、最后直接push代码到远端仓库

遇到的问题：如果遇到报错。可能由于本地远程仓库冲突，提示用如下命令：

**git pull origin master --allow-unrelated-histories** //把远程仓库和本地同步，消除差异，主要是创建的时候创建了read.md文件，所以去差异化。

####  二、git的一些常用命令

![image-20200617092123958](C:\Users\jiangll01\AppData\Roaming\Typora\typora-user-images\image-20200617092123958.png)

##### 1、git stash 的常用命令

​		git stash 指的是将代码存储到了暂存区（stash)，并没有提交到本地仓库，运用场景：当我们在当前分支已经进行了大量的修改了，但是这个时候需要解决写之前的一些代码bug，此时我们的代码还没写完，可能有问题，没办法提交到本地仓库，所以我们需要将自己写的代码提交到暂存区中，并且恢复到写之前。

**git stash save "save message"**       执行存储时，添加备注，方便查找，只有git stash 也要可以的，但查找时不方便识别。

**git stash list**   查看stash了哪些存储

**git stash show**    显示做了哪些改动，默认show第一个存储,如果要显示其他存贮，后面加stash@{$num}，比如第二个 git stash show stash@{1}

**git stash apply**    应用某个存储,但不会把存储从存储列表中删除，默认使用第一个存储,即stash@{0}，如果要使用其他个，git stash apply stash@{$num} ， 比如第二个：git stash apply stash@{1} 

**git stash pop**       命令恢复之前缓存的工作目录，将缓存堆栈中的对应stash删除，并将对应修改应用到当前的工作目录下,默认为第一个stash,即stash@{0}，如果要应用并删除其他stash，命令：git stash pop stash@{$num} ，比如应用并删除第二个：git stash pop stash@{1}

**git stash drop** stash@{$num}     丢弃stash@{$num}存储，从列表中删除这个存储

**git stash clear**   删除所有缓存的stash

##### 2、git fetch

​		先用一张图来理一下`git fetch`和`git pull`的概念：

![img](http://kmknkk.oss-cn-beijing.aliyuncs.com/image/git.jpg)

可以简单的概括为：

`git fetch`是将远程主机的最新内容拉到本地，用户在检查了以后决定是否合并到工作本机分支中。

而`git pull` 则是将远程主机的最新内容拉下来后直接合并，即：`git pull = git fetch + git merge`，这样可能会产生冲突，需要手动解决。

下面我们来详细了解一下`git fetch` 和`git pull` 的用法。 

##### 3、git checkout

​		在日常的git操作中，git checkout——检出，是我们的常用命令。最为常用的两种情形是创建分支和切换分支。git checkout`命令用于切换分支或恢复工作树文件。`git checkout`是git最常用的命令之一，同时也是一个很危险的命令，因为这条命令会重写工作区。

##### 4、git的reset和checkout的区别

​		在讲git的reset和checkout的区别之前，不得不说说HEAD、Index、Working Directory三个区域。

`HEAD、Index、Working Directory`

Git里有三个区域很重要

1. HEAD 指向最近一次commit里的所有snapshot
2. Index 缓存区域，只有Index区域里的东西才可以被commit
3. Working Directory 用户操作区域

下图解释了这三个区域的状态的变化过程：

![图片描述](https://segmentfault.com/img/bVz7pc?w=500&h=411)

**初始化：**

当你checkout分支的时候，git做了这么三件事情

1. 将HEAD指向那个分支的最后一次commit
2. 将HEAD指向的commit里所有文件的snapshot替换掉Index区域里原来的内容
3. 将Index区域里的内容填充到Working Directory里

所以你可以发现，HEAD、Index、Working Directory这个时候里的内容都是一模一样的。

**注意**：一般会误解为，Index中的内容是空的，只有git add后才会有东西。实际上不是，Index里一直是有东西的。

所以，Git的所有操作就是对这三个区域的状态（或内容）的操作。

**changed**

如果你在Working Directory里修改了文件，git会发现Working Directory里的内容和Index区域里的内容不一致了。

这个时候git status的结果是：

```
# Changes not staged for commit:
```

**Committed**

最后，你就可以提交了

git commit

这样，就把HEAD的状态和Index以及Working Directory形成一致了。

**reset**

reset是用来修改提交历史的，想象这种情况，如果你在2天前提交了一个东西，突然发现这次提交是有问题的。

这个时候你有两个选择，要么使用git revert（推荐），要么使用git reset。

![图片描述](https://segmentfault.com/img/bVz7ph?w=236&h=238)

上图可以看到git reset是会**修改**版本历史的，他会丢弃掉一些版本历史。

而git revert是根据那个commit逆向生成一个新的commit，版本历史是不会被破坏的



**已经push到远程仓库的commit不允许reset**

上面已经讲了，git reset是会丢弃掉commit的。

如果commit已经被push到远程仓库上了，也就意味着其他开发人员就可能基于这个commit形成了新的commit，这时你去reset，就会造成其他开发人员的提交历史莫名其妙的丢失，或者其他灾难性的后果。

因此，一旦commit已经被push到远程仓库，那么是坚决不允许去reset它的。



**不带文件参数的rese**t

前面章节已经说道Git有三个区域，Git的所有操作实际上是在操作这三个区域的状态（或内容）。

git reset配合不同的参数，对这三个区域会产生不同的影响。

reset实际上有3个步骤，根据不同的参数可以决定执行到哪个步骤(`--soft`, `--mixed`, `--hard`)。

1. 改变HEAD所指向的commit(`--soft`)

2. 执行第1步，将Index区域更新为HEAD所指向的commit里包含的内容(`--mixed`)

3. 执行第1、2步，将Working Directory区域更新为HEAD所指向的commit里包含的内容(`--hard`)

   

   –mixed`是默认参数，也就是说执行reset的时候不给就认为是`--mixed`。

   下表说明了三种形式的git reset所产生的不同效果。

   target代表想要将git指向到哪个commit

   ```
   working index HEAD target         working index HEAD
   ----------------------------------------------------
     A       B     C    D     --soft   A       B     D
                              --mixed  A       D     D
                              --hard   D       D     D
                              --merge (disallowed)
   
   working index HEAD target         working index HEAD
   ----------------------------------------------------
     A       B     C    C     --soft   A       B     C
                              --mixed  A       C     C
                              --hard   C       C     C
                              --merge (disallowed)
   ```

   **带文件参数的reset**

   ​	上面讲到的git reset实际上不带参数的，如果带上文件参数，那么效果会是怎样的？

   HEAD不会动

   将那个commit的snapshot里的那个文件放到Index区域中

需要注意的是带文件参数的git reset没有--hard, --soft这两个参数。只有--mixed参数。



**unstage**

下面这两个命令是一样的，都是reset到HEAD上。

```
git reset file.txt
git reset --mixed HEAD file.txt
```

这个例子的意义在于，unstage file，仔细想一想是不是这样？当你把一个文件stage到Index区域里后后悔了，那么只需要把Index区域里的这个文件恢复到最近一次commit的状态（也就是HEAD），那就相当于unstage了。

**恢复到历史版本**

下面这个命令就是将某个文件恢复到历史版本上。

```
reset eb43bf file.txt
```

这个例子的意思在于，把某个文件恢复到Index区域里，然后直接commit，这样就等于把这个文件恢复到历史版本了，这样依赖你都不需要去改动Working Directory了。

**checkout**

前面讲到checkout是会修改HEAD的指向，变更Index区域里的内容，修改Working Directory里的内容。

这看上去很像`reset --hard`，但和`reset --hard`相比有两个重要的差别

1. reset会把working directory里的所有内容都更新掉
2. checkout不会去修改你在Working Directory里修改过的文件
3. reset把branch移动到HEAD指向的地方
4. checkout则把HEAD移动到另一个分支

第二个区别可能有点难以理解，举例来说：假设你有两个分支master和develop，这两个分支指向不一样的commit，我们现在在develop分支上（HEAD指向的地方）

如果我们`git reset master`，那么develop就会指向master所指向的那个commit。

如果我们`git checkout master`，那么develop不会动，只有HEAD会移动。HEAD会指向master。看图：

![图片描述](https://segmentfault.com/img/bVz7pB?w=500&h=366)

**带文件参数**

当执行git checkout [branch] file时，checkout干了这件事情：

1. 更新了index区域里file文件的内容
2. 更新了working directory里file文件的内容

**总结reset和checkout**

```
                         head    index   work dir  wd safe
Commit Level
reset --soft [commit]    REF     NO      NO        YES
reset [commit]           REF     YES     NO        YES
reset --hard [commit]    REF     YES     YES       NO
checkout [commit]        HEAD    YES     YES       YES

File Level
reset (commit) [file]    NO      YES     NO        YES
checkout (commit) [file] NO      YES     YES       NO
```

“head”一列中的“REF”表示该命令移动了HEAD指向的分支引用，而“HEAD”则表示只移动了HEAD自身。 特别注意 “wd safe?” 一列，YES表示不会懂你在work dir的修改，NO代表会动你在work dir的修改。







#####  5、idea回滚记录

![image-20200804104755699](C:\Users\jiangll01\AppData\Roaming\Typora\typora-user-images\image-20200804104755699.png)

![image-20200804105649712](C:\Users\jiangll01\AppData\Roaming\Typora\typora-user-images\image-20200804105649712.png)

![image-20200804112703441](C:\Users\jiangll01\AppData\Roaming\Typora\typora-user-images\image-20200804112703441.png)
