param (
    [Parameter(Mandatory=$true)]
    [string]$ExerciseName,
    
    [Parameter(Mandatory=$false)]
    [string]$StatusDescription = "Completed and runs properly."
)

$StatusFile = "status.md"
$Prefix="src\main\java"

# Define the path for the exercise and status file
$ExercisePath = Join-Path -Path $Prefix -ChildPath $ExerciseName
#Status file is inside exercise directory
$StatusFilePath = Join-Path -Path $ExercisePath -ChildPath $StatusFile

# 1. Create the exercise directory and starter file
if (-not (Test-Path $ExercisePath)) {
    New-Item -ItemType Directory -Path "$ExercisePath" | Out-Null
    # New-Item -ItemType File -Path "$ExercisePath\main.py" | Out-Null
    Write-Host "✅ Created directory and template file for $ExerciseName" -ForegroundColor Green
}

# 2. Create or initialize status.md [cite: 9]
if (-not (Test-Path $StatusFilePath)) {
    $InitialContent = @"
# Assignment Completion Status

## Completed Exercises

## Incomplete Exercises
"@
    Set-Content -Path $StatusFilePath -Value $InitialContent
}

# 3. Append the exercise status cleanly [cite: 5, 6, 7]
$Content = Get-Content $StatusFilePath
$NewContent = @()

foreach ($Line in $Content) {
    $NewContent += $Line
    if ($Line -eq "## Completed Exercises") {
        $NewContent += "- [x] $($ExerciseName): $($StatusDescription)"
    }
}

Set-Content -Path $StatusFilePath -Value $NewContent
Write-Host "📝 Added $ExerciseName to $StatusFile" -ForegroundColor Cyan