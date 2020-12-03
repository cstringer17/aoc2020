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

    
    $min = $minmax[0] -as [int]
    $max = $minmax[1] -as [int]

  
    if($passwordArray[$min-1] -like $letter -And $passwordArray[$max-1] -notlike $letter  ){
        $goodpasswords++
        Write-Output $passwordArray[$min] 
        Write-Output $passwordArray[$max]
        Write-Output $letter
        
    }else{
        $badpasswords++
    }

    if($passwordArray[$min-1] -notlike $letter -And $passwordArray[$max-1] -like $letter  ){
        $goodpasswords++
        Write-Output $passwordArray[$min] 
        Write-Output $passwordArray[$max]
        Write-Output $letter
        
    }else{
        $badpasswords++
    }


    Write-Output "------"
}

Write-Output $goodpasswords