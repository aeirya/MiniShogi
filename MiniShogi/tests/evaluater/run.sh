#### run from src

javac $(find **/*.java) Main.java

i=1
while true;
do
    echo $i
    file="../tests/in/input$i.txt"

    # only continue if there's a non-empty file
    
    if ! [[ -f "$file" ]]; then
        break
    fi
    echo hi
    if ! [[ -s "$file" ]]; then
        let "i++"
        continue
    fi
    echo hi

    out="../tests/out/output$i.txt"

    cat $file | java Main > $out
    echo hi

    let "i++"
done

rm **/*.class