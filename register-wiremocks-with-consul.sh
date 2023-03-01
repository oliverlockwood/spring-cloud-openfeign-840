#!/bin/bash
docker exec -d consul consul services register -name downstream-service -address 127.0.0.1 -port 18000 -id downstream-service-1
docker exec -d consul consul services register -name downstream-service -address 127.0.0.1 -port 18001 -id downstream-service-2
