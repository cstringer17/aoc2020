[string[]]$arrayFromFile = Get-Content -Path 'D:\Programming\aoc\aoc-PasswordPhilosophy\input.txt' 
$goodpasswords = 0
$badpasswords = 0
Foreach ($line in $arrayFromFile)
{
    $partLine = $line.Split(" ")

    $minmax = $partLine[0].Split("-")
    $letter = $partLine[1].ToCharArray()[0]
    $password = $partLine[2]
    
    $passwordArray = $password.ToCharArray();
    $letterCounter = 0;

    Foreach ($char in $passwordArray)
    {
    if($char -eq $letter)
        {
        $letterCounter++
        }
    }
    $min = $minmax[0] -as [int]
    $max = $minmax[1] -as [int]

    if($min -le $letterCounter -And $max -ge $letterCounter){
        $goodpasswords++
    }else{
        $badpasswords++
    }
}

Write-Output $goodpasswords