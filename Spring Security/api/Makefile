package:
	@ mvn clean package

docker-image-build: package
	@ docker build -t api/manager .

run: docker-image-build
	@ docker compose up

stop:
	@ docker compose down -v
