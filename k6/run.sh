docker-compose stop
docker-compose rm -f
docker-compose up -d influxdb grafana
echo "--------------------------------------------------------------------------------------"
echo "Load testing with Grafana dashboard http://localhost:3000/d/k6/k6-load-testing-results"
echo "--------------------------------------------------------------------------------------"
echo "$1"
docker-compose run --rm k6 run //scripts//ewoks.js -e MY_PORT="$1"