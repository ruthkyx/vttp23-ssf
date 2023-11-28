# runtime 
FROM node:20

#creating directory
WORKDIR /app

# required files in app
COPY main.js .
COPY package-lock.json .
COPY package.json .

COPY public public 
COPY views views

# build app/ install the dependencies
RUN npm ci

# env variables to run the app
ENV PORT=3000
ENV INSTANCE_NAME="dov-bear"

EXPOSE ${PORT}

# run programme => type this in the terminal
ENTRYPOINT SERVER_PORT=${PORT} node main.js