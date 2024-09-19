FROM postgres:latest

ENV POSTGRES_USER "slowhigh"
ENV POSTGRES_PASSWORD "cloudnote1!"
ENV POSTGRES_DB "cloudnote"
ENV TIMEZONE "Asia/Seoul"

CMD ["postgres"]