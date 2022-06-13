i=10

while true;
do
    echo $i
    file="../tests/newIn/input$i.txt"

    if ! [[ -f "$file" ]]; then
        break
    fi
    if ! [[ -s "$file" ]]; then
        let "i++"
        continue
    fi

    rm -f tmp
    while read line
    do
        if [[ $line == "0" ]]; then 
            echo "0" >> tmp
        else
            echo $line | python3 "../tests/evaluater/translate.py" >> tmp
        fi
    done < "$file"

    echo "0" >> tmp

    cat tmp > "../tests/newInNew/input$i.txt"
    rm tmp
    
    let "++i"
done