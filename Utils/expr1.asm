; entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

; ouvrePrinc10
mov bp,sp
sub sp,10

; iconst
push 2
push 2
push 3
; imul
pop bx
pop ax
imul bx
push ax

; iadd
pop bx
pop ax
add ax,bx
push ax

; istore
pop ax
mov word ptr[bp-10],ax

; iconst
push word ptr[bp-10]
ecrireEnt
aLaLigne
; iconst
push 2
push 2
push 2
push 1
; iadd
pop bx
pop ax
add ax,bx
push ax

; iconst
push 2
; iadd
pop bx
pop ax
add ax,bx
push ax

; imul
pop bx
pop ax
imul bx
push ax

; iadd
pop bx
pop ax
add ax,bx
push ax

ecrireEnt
; queue
nop
exitcode
end debut

