#!/usr/bin/env bash
mvn_version=` mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | sed -n -e '/^\[.*\]/ !{ /^[0-9]/ { p; q } }'`
http_return_code=` curl --write-out %{http_code} --silent --output /dev/null https://hub.docker.com/v2/repositories/corphub/corphub-backend/tags/${mvn_version}`
if [ "$http_return_code" = "404" ]; then
   echo "New version: "${mvn_version} "- Continuing build."
   return 1;
else
    echo "HTTP return code: " ${http_return_code}
    echo "Not a new version: ${mvn_version} - Aborting build."
    return 0;
fi