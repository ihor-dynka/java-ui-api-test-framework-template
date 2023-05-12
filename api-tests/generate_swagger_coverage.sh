VERSION=1.4.4
APP_HOST_URL=

curl "https://github.com/viclovsky/swagger-coverage/releases/download/$VERSION/swagger-coverage-$VERSION.zip" -o "${PWD}/swagger-coverage-$VERSION.zip"

unzip -o "${PWD}/swagger-coverage-$VERSION.zip"

curl "$APP_HOST_URL/api/v1/swagger" -o "${PWD}/swagger.json"

./swagger-coverage-commandline-1.4.4/bin/swagger-coverage-commandline -s "${PWD}/swagger.json" -i "${PWD}/swagger-coverage-output"

