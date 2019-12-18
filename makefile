.PHONY: run-server run stop-all

run-server:
	cd src/lab/server; \
		make build; \
		make run

run: run-server
	cd src/lab/client; \
		make build; \
		make run

stop-all:
	./reset.sh
