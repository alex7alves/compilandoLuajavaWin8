LIBNAME = lpeglabel
#LUADIR = ../lua/
LUADIR = C:\Users\alve\Desktop\luaj\lua524\src
COPT = -O2
# COPT = -DLPEG_DEBUG -g

CWARNS = -Wall -Wextra -pedantic \
	-Waggregate-return \
	-Wcast-align \
	-Wcast-qual \
	-Wdisabled-optimization \
	-Wpointer-arith \
	-Wshadow \
	-Wsign-compare \
	-Wundef \
	-Wwrite-strings \
	-Wbad-function-cast \
	-Wdeclaration-after-statement \
	-Wmissing-prototypes \
	-Wnested-externs \
	-Wstrict-prototypes \
# -Wunreachable-code \


CFLAGS = $(CWARNS) $(COPT) -std=c99 -I$(LUADIR) -fPIC
CC = gcc

FILES = lpvm.o lpcap.o lptree.o lpcode.o lpprint.o

# For Linux
linux:
	make lpeglabel.so "DLLFLAGS = -shared -fPIC"

# For Mac OS
macosx:
	make lpeglabel.so "DLLFLAGS = -bundle -undefined dynamic_lookup"
mina: 	 
	$(CC) $(DLLFLAGS) $(FILES) -shared -o lpeglabel.dll  -LC:\Users\alve\Desktop\luaj\lua524\src
lpeglabel.so: 

$(FILES): makefile

test: test.lua re.lua lpeglabel.so
	./test.lua

clean:
	rm -f $(FILES) lpeglabel.dll


lpcap.o: lpcap.c lpcap.h lptypes.h
lpcode.o: lpcode.c lptypes.h lpcode.h lptree.h lpvm.h lpcap.h
lpprint.o: lpprint.c lptypes.h lpprint.h lptree.h lpvm.h lpcap.h
lptree.o: lptree.c lptypes.h lpcap.h lpcode.h lptree.h lpvm.h lpprint.h
lpvm.o: lpvm.c lpcap.h lptypes.h lpvm.h lpprint.h lptree.h

