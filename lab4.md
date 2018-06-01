# Practica4

## Creación de la cuenta de openshift e instalación del cliente

Para la creación de la cuenta se ha utilizado el siguiente enlace sin complicaciones

https://manage.openshift.com/

Una vez creada la cuenta es necesario utilizar el cliente de openshift (en mi caso para linux)

Este cliente puede descargarse desde:

https://access.redhat.com/downloads/content/290

Sin embargo, es necesario solicitar el servicio de prueba para estudiantes.

Una vez descargado se descomprime y se inicia sesión con:

./oc login https://api.starter-ca-central-1.openshift.com --token=...

Este comando depende de cada usuario y puede encontrarse en la pestaña command-line tools en la página de openshift



## Creación del proyecto

Para crear un proyecto hay que seleccionar en abrir consola web.

Desde la consola hay que pulsar en create project y escribir el nombre del proyecto (lab0)

## Despliegue a partir de un war

Como el link de las instrucciones de la practica 4 está roto, se ha seguido el tutorial de:

https://blog.openshift.com/deploying-war-file-openshift-online-3/

Desde la terminal hay que ejecutar el siguiente comando para crear la instancia de computo

./oc new-app wildfly:latest~. --name lab0

Para desplegar el war hay que ejecutar:

./oc start-build lab0 --from-file=lab0.war

Para que la aplicación sea visible hay que ejecutar

./oc expose svc lab0

En la consola de openshift aparece la dirección en la que se ha desplegado la aplicación.

En mi caso, la aplicación está en:

http://lab0-lab0.193b.starter-ca-central-1.openshiftapps.com/


Por desgracia, al acceder a la aplicación no aparece la practica 0, sino una página de bienvenida a wildfly.



