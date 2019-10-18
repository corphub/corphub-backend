#!/bin/sh
latesttag=$(git describe --tags `git rev-list --tags --max-count=1`)
echo checking out ${latesttag}
git checkout ${latesttag}
patch_version=` mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | sed -n -e '/^\[.*\]/ !{ /^[0-9]/ { p; q } }'`
echo found patch version: ${patch_version}
IFS='.' read -r -a versions <<< "$patch_version"
#IFS='.' read -r -a version <<< ${patch_version}
feature_version=${versions[0]}.${versions[1]}
major_version=${versions[0]}
echo found feature version: ${feature_version}
echo found major version: ${major_version}

docker build --cache-from corphub/corphub-backend --build-arg POM_VERSION=${patch_version} -t corphub/corphub-backend:${patch_version} -t corphub/corphub-backend:${feature_version} -t corphub/corphub-backend:${major_version} -t corphub/corphub-backend:latest .
docker push corphub/corphub-backend