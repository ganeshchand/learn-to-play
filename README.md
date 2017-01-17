#Learn Play Framework With Scala

##How to run examples:

Steps:

```bash
$ git clone https://github.com/ganeshchand/learn-to-play.git

$ sbt

$ run

```

Open a browser and use http://localhost:9000

####Using Curl Commands:

```bash 
$ curl -v 'http://localhost:9000/`

$ curl -v 'http://localhost:9000/hello/ganesh`

$ curl -v 'http://localhost:9000/time`

$ curl -v 'http://localhost:9000/zones`

$ curl -v 'http://localhost:9000/time/CET`

$ curl -v 'http://localhost:9000/time/America%2fLos_Angeles`

$ curl -v 'http://localhost:9000/say/hello/5/times`


#Using Query Parameter - with default values


$ curl -v 'http://localhost:9000/greet`

$ curl -v 'http://localhost:9000/greet?user=ganesh`

$ curl -v 'http://localhost:9000/greet?user=ganesh&&message="Complete your exercise"`

```



