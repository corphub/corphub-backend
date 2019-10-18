#!/bin/sh
BRANCH=$1
echo branch: ${BRANCH}
if [[ "$BRANCH" == "master" ]]; then
    latesttag=$(git describe --tags `git rev-list --tags --max-count=1`)
    echo checking out ${latesttag}
    git checkout ${latesttag}
fi
full_version=` mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | sed -n -e '/^\[.*\]/ !{ /^[0-9]/ { p; q } }'`
echo found version: ${full_version}
IFS='.' read -r -a versions <<< "full_version"
feature_version=${versions[0]}.${versions[1]}
major_version=${versions[0]}
echo found feature version: ${feature_version}
echo found major version: ${major_version}

if [[ "$BRANCH" == "master" ]]; then
    echo building release version
    docker build --cache-from corphub/corphub-backend --build-arg POM_VERSION=${full_version} -t corphub/corphub-backend:${full_version} -t corphub/corphub-backend:${feature_version} -t corphub/corphub-backend:${major_version} -t corphub/corphub-backend:latest .
    docker push corphub/corphub-backend
fi
if [[ "$BRANCH" == "dev" ]]; then
    echo building snapshot version
    docker build --cache-from corphub/corphub-backend --build-arg POM_VERSION=${full_version} -t corphub/corphub-backend:snapshot .
    docker push corphub/corphub-backend
fi

