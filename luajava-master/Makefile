#
# Makefile for LuaJava Linux Distribution
#

include ./config
#JDK= C:\Program Files\Java\jdk1.7.0_51

CLASSES     = \
	src/java/org/keplerproject/luajava/CPtr.class \
	src/java/org/keplerproject/luajava/JavaFunction.class \
	src/java/org/keplerproject/luajava/LuaException.class \
	src/java/org/keplerproject/luajava/LuaInvocationHandler.class \
	src/java/org/keplerproject/luajava/LuaJavaAPI.class \
	src/java/org/keplerproject/luajava/LuaObject.class \
	src/java/org/keplerproject/luajava/LuaState.class \
	src/java/org/keplerproject/luajava/LuaStateFactory.class \
	src/java/org/keplerproject/luajava/Console.class

DOC_CLASSES	= \
	src/java/org/keplerproject/luajava/JavaFunction.java \
	src/java/org/keplerproject/luajava/LuaException.java \
	src/java/org/keplerproject/luajava/LuaInvocationHandler.java \
	src/java/org/keplerproject/luajava/LuaObject.java \
	src/java/org/keplerproject/luajava/LuaState.java \
	src/java/org/keplerproject/luajava/LuaStateFactory.java \
	src/java/org/keplerproject/luajava/Console.java

OBJS        = src/c/luajava.o
.SUFFIXES: .java .class

#
# Targets
#
run: build
	@echo ------------------
	@echo Build Complete
	@echo ------------------

build: checkjdk $(JAR_FILE) apidoc $(SO_FILE)

#
# Build .class files.
#
.java.class:
	javac -sourcepath ./src/java $*.java

#
# Create the JAR
#
$(JAR_FILE): $(CLASSES)
	cd src/java & jar cvf ../../$(JAR_FILE) org/keplerproject/luajava/*.class & cd ../..
  
#
# Create the API Documentation
#
apidoc:
	javadoc -public -classpath src/java/ -quiet -d "doc/us/API" $(DOC_CLASSES)

#
# Build .c files.
#
$(SO_FILE): $(OBJS)
	 $(CC) $(LIB_OPTION) -o $@ $? $(LIB_LUA)

src/c/luajava.c: src/c/luajava.h

src/c/luajava.h:
	javah -o src/c/luajava.h -classpath "$(JAR_FILE)" org.keplerproject.luajava.LuaState
 
src/c/luajava.o: src/c/luajava.c
	$(CC) -c $(CFLAGS) -o $@ $<


## regras implicitas para compilacao

$(OBJDIR)/%.o:  %.c
	$(CC) -c $(CFLAGS) -o $@ $<

#
# Check that the user has a valid JDK install.  This will cause a
# premature death if JDK is not defined.
#
checkjdk: C:/Program\ Files/Java/jdk1.7.0_51/bin/java.exe

#
# Cleanliness.
#
clean:
	rm -f $(JAR_FILE)
	rm -f $(SO_FILE)
	rm -rf doc/us/API
	rm -f src/java/org/keplerproject/luajava/*.class src/c/*.o src/c/luajava.h
	rm -f $(TAR_FILE) $(ZIP_FILE)

dist:	dist_dir
	tar -czf $(TAR_FILE) --exclude \*CVS\* --exclude *.class --exclude *.o --exclude *.h --exclude $(TAR_FILE) --exclude $(ZIP_FILE) $(DIST_DIR)
	zip -qr $(ZIP_FILE) $(DIST_DIR)/* -x ./\*CVS\* *.class *.o *.h ./$(TAR_FILE) ./$(ZIP_FILE)

dist_dir:	apidoc
	mkdir -p $(DIST_DIR)
	cp -R src $(DIST_DIR)
	cp -R doc $(DIST_DIR)
	cp -R test $(DIST_DIR)
	cp config License.txt Makefile config.win Makefile.win $(DIST_DIR)

