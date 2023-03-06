#!/bin/bash
#version avec dockerhub
#docker login -u 'username' -p 'password'
#cd /home/boilerplate/ressource/backend/
#docker build --pull -t userrepo/imagename .
#docker push userrepo/imagename:latest

docker image build -t NOM_DE_L_IMAGE  CHEMIN_VERS_LE_DOCKER_FILE
