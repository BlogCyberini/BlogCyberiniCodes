//Code by Henrique Felipe (GitHub: HenriqueIni)

//Euclid's algorithm (recursive)
function gcdRecursive(a, b) {
    if (b == 0) {
        return a;
    }
    return gcdRecursive(b, a % b);
}
//Euclid's algorithm (iterative)
function gcdIterative(a, b) {
    while(b != 0){
        var r = a % b;
        a = b;
        b = r;
    }
    return a;
}
function tests() {
    //Tests recursive
    var output = "GCD recusive\n";
    output += "gcd(30, 60) = " + gcdRecursive(30, 60) + "\n";
    output += "gcd(50, 12) = " + gcdRecursive(50, 12) + "\n";
    output += "gcd(100, 11) = " + gcdRecursive(100, 11) + "\n\n";
    //Tests iterative
    output += "GCD iterative\n";
    output += "gcd(30, 60) = " + gcdIterative(30, 60) + "\n";
    output += "gcd(50, 12) = " + gcdIterative(50, 12) + "\n";
    output += "gcd(100, 11) = " + gcdIterative(100, 11);
    //output
    alert(output);
}
