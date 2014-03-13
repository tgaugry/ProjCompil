; entete 
extrn lirent:proc, ecrent:proc, ecrbool:proc, ecrch:proc, ligsuiv:proc 
.model SMALL 
.586 

.CODE 
debut : 
STARTUPCODE 


; ouvrePrinc 6
mov bp, sp 
sub sp, 6


; iconst 2
push word ptr 2


; istore -2
pop ax 
mov word ptr [bp-2], ax 


; iconst -1
push word ptr -1


; istore -6
pop ax 
mov word ptr [bp-6], ax 


; iconst 2
push word ptr 2


; iload -2
push word ptr [bp-2] 


; imul 
pop bx 
pop ax 
imul bx 
push ax 


; iload -6
push word ptr [bp-6] 


; iconst 3
push word ptr 3


; queue 
nop 
EXITCODE 
End debut 


