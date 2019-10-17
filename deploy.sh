#!/usr/bin/env bash
docker-ci-deploy --tag latest --tag $(git describe --tags $(git rev-list --tags --max-count=1)) corphub/corphub-backend:latest