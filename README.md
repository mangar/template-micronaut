# Template Micronaut


## Testing

__Run the tests__

```./gradlew test ```

__Report__

```
open open build/reports/tests/test/index.html
```



# Docker

__Build the image__

1. Build the App: ```./gradlew build```
2. Create the machine: ```docker build -t template-micronaut:0.0.1 .```


__Fire the WebApp__

8. Run the docker image with the App: 
```
docker run -e PORT=8080 -m512M --cpus 2 -it -p 8080:8080 --name template-micronaut --rm template-micronaut:0.0.1
```

__Enjoy__

9. Access: <http://localhost:8080/about> / <http://localhost:8080/v1/hello> 

---

__Copyright__

The MIT License (MIT)
Copyright (c) 2019 Marcio Mangar






